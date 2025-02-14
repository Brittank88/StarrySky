package de.dafuqs.starrysky.dimension.spheroid.spheroids;

import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.Support;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.dimension.SpheroidDecorator;
import de.dafuqs.starrysky.dimension.spheroid.SpheroidEntitySpawnDefinition;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.*;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkRandom;
import org.apache.logging.log4j.Level;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import static org.apache.logging.log4j.Level.WARN;

public abstract class Spheroid implements Serializable {

    protected SpheroidAdvancementIdentifier spheroidAdvancementIdentifier;
    protected ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn;
    protected BlockPos position;
    protected int radius;
    protected ChunkRandom random;

    /**
     * Chunks this spheroid should be still generated in
     **/
    private final HashSet<ChunkPos> chunksOfSpheroid = new HashSet<>();
    /**
     * The decorators that should be ran after generation
     **/
    private final ArrayList<SpheroidDecorator> spheroidDecorators;

    public Spheroid(SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, ChunkRandom random, ArrayList<SpheroidDecorator> spheroidDecorators, int radius, ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn) {
        this.spheroidAdvancementIdentifier = spheroidAdvancementIdentifier;
        this.random = random;
        this.spheroidDecorators = spheroidDecorators;
        this.radius = radius;
        this.entityTypesToSpawn = entityTypesToSpawn;
    }

    public abstract void generate(Chunk chunk);

    public BlockPos getPosition() {
        return position;
    }

    public void setPositionAndCalculateChunks(BlockPos blockPos) {
        this.position = blockPos;

        for (int currXPos = blockPos.getX() - radius; currXPos <= blockPos.getX() + radius; currXPos++) {
            for (int currZPos = blockPos.getZ() - radius; currZPos <= blockPos.getZ() + radius; currZPos++) {
                int cx = (int) Math.floor(currXPos / 16.0D);
                int cz = (int) Math.floor(currZPos / 16.0D);
                this.chunksOfSpheroid.add(new ChunkPos(cx, cz));
            }
        }
    }

    public SpheroidAdvancementIdentifier getSpheroidAdvancementIdentifier() {
        return spheroidAdvancementIdentifier;
    }

    public int getRadius() {
        return radius;
    }

    public abstract String getDescription();

    public boolean isInChunk(ChunkPos chunkPos) {
        return this.chunksOfSpheroid.contains(chunkPos);
    }

    public boolean hasDecorators() {
        return this.spheroidDecorators.size() > 0;
    }

    public void decorate(StructureWorldAccess world, Random random, BlockPos origin) {
        for (SpheroidDecorator decorator : this.spheroidDecorators) {
            StarrySkyCommon.log(Level.DEBUG, "Decorator: " + decorator.getClass());
            try {
                decorator.decorateSpheroid(world, this, origin, random);
            } catch (RuntimeException e) {
                // We are asking a region for a chunk out of bound ಠ_ಠ
            }
        }
    }

    protected boolean isTopBlock(long d, double x, double y, double z) {
        if (d == this.radius) {
            long dist2 = Math.round(Support.getDistance(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(), x, y + 1, z));
            return dist2 > this.radius;
        } else {
            return false;
        }
    }

    protected boolean isBottomBlock(long d, double x, double y, double z) {
        if (d == this.radius) {
            long dist2 = Math.round(Support.getDistance(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(), x, y - 1, z));
            return dist2 > this.radius;
        } else {
            return false;
        }
    }

    protected boolean isAboveCaveFloorBlock(long d, double x, double y, double z, int shellRadius) {
        if(d == (this.radius - shellRadius)) {
            int distance1 = (int) Math.round(Support.getDistance(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(), x, y - 1, z));
            return distance1 > (this.radius - shellRadius);
        }
        return false;
    }

    protected void placeCenterChestWithLootTable(Chunk chunk, BlockPos blockPos, Identifier lootTable, Random random, boolean waterLogged) {
        BlockState chestBlockState;
        if (waterLogged) {
            chestBlockState = Blocks.CHEST.getDefaultState().with(ChestBlock.WATERLOGGED, true);
        } else {
            chestBlockState = Blocks.CHEST.getDefaultState();
        }
        chunk.setBlockState(blockPos, chestBlockState, false);
        chunk.setBlockEntity(new ChestBlockEntity(blockPos, chestBlockState));
        LootableContainerBlockEntity.setLootTable(chunk, random, blockPos, lootTable);
    }

    public boolean shouldPopulateEntities(ChunkPos chunkPos) {
        return isCenterInChunk(chunkPos);
    }

    public boolean isCenterInChunk(ChunkPos chunkPos) {
        return (this.getPosition().getX() >= chunkPos.getStartX()
                && this.getPosition().getX() <= chunkPos.getStartX() + 15
                && this.getPosition().getZ() >= chunkPos.getStartZ()
                && this.getPosition().getZ() <= chunkPos.getStartZ() + 15);
    }

    public boolean isCenterInChunkBlockPos(BlockPos blockPos) {
        return (this.getPosition().getX() >= blockPos.getX()
                && this.getPosition().getX() <= blockPos.getX() + 15
                && this.getPosition().getZ() >= blockPos.getZ()
                && this.getPosition().getZ() <= blockPos.getZ() + 15);
    }

    public void populateEntities(ChunkPos chunkPos, ChunkRegion chunkRegion, ChunkRandom chunkRandom) {
        if (shouldPopulateEntities(chunkPos)) {
            StarrySkyCommon.log(Level.DEBUG, "Populating entities for spheroid in chunk x:" + chunkPos.x + " z:" + chunkPos.z + " (StartX:" + chunkPos.getStartX() + " StartZ:" + chunkPos.getStartZ() + ") " + this.getDescription());
            for (SpheroidEntitySpawnDefinition entityTypeToSpawn : entityTypesToSpawn) {
                int xCord = chunkPos.getStartX();
                int zCord = chunkPos.getStartZ();

                ChunkRandom sharedSeedRandom = new ChunkRandom();
                sharedSeedRandom.setPopulationSeed(chunkRegion.getSeed(), xCord, zCord);

                int randomAmount = Support.getRandomBetween(random, entityTypeToSpawn.minAmount, entityTypeToSpawn.maxAmount);
                for (int i = 0; i < randomAmount; i++) {

                    int height;
                    BlockPos spheroidTopPosition = this.getPosition().up(this.getRadius() + 1);
                    if(chunkRegion.isAir(spheroidTopPosition)) {
                        height = Support.getLowerGroundBlock(chunkRegion, spheroidTopPosition,chunkRegion.getLogicalHeight());
                    } else {
                        height = Support.getUpperGroundBlock(chunkRegion, spheroidTopPosition,chunkRegion.getLogicalHeight());
                    }

                    Entity entity = entityTypeToSpawn.entityType.create(chunkRegion.toServerWorld());
                    if (entity != null) {
                        try {
                            entity.refreshPositionAndAngles(spheroidTopPosition.getX() + 0.5, height, spheroidTopPosition.getZ() + 0.5, sharedSeedRandom.nextFloat() * 360.0F, 0.0F);
                            if (entity instanceof MobEntity) {
                                MobEntity mobentity = (MobEntity) entity;
                                if (mobentity.canSpawn(chunkRegion, SpawnReason.CHUNK_GENERATION)) {
                                    mobentity.initialize(chunkRegion, chunkRegion.getLocalDifficulty(new BlockPos(mobentity.getPos())), SpawnReason.CHUNK_GENERATION, null, null);
                                    chunkRegion.spawnEntity(mobentity);
                                }
                            }
                        } catch (Exception exception) {
                            StarrySkyCommon.log(WARN, "Failed to spawn mob on sphere" + this.getDescription() + "\nException: " + exception.getMessage());
                        }
                    }
                }
            }
            StarrySkyCommon.log(Level.DEBUG, "Finished populating");
        }
    }

    public boolean shouldDecorate(BlockPos blockPos) {
        return this.chunksOfSpheroid.contains(new ChunkPos(blockPos.getX() / 16, blockPos.getZ() / 16));
    }

    protected void placeSpawner(WorldAccess worldAccess, BlockPos blockPos, EntityType entityType) {
        worldAccess.setBlockState(blockPos, Blocks.SPAWNER.getDefaultState(), 3);
        BlockEntity blockEntity = worldAccess.getBlockEntity(blockPos);
        if (blockEntity instanceof MobSpawnerBlockEntity) {
            ((MobSpawnerBlockEntity) blockEntity).getLogic().setEntityId(entityType);
        }
    }

}
