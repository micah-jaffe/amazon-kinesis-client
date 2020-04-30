package com.amazonaws.services.kinesis.clientlibrary.lib.worker;

import com.amazonaws.services.kinesis.leases.impl.KinesisClientLease;
import com.amazonaws.services.kinesis.model.Shard;

import java.util.List;
import java.util.Set;

/**
 * Interface used by {@link KinesisShardSyncer} to determine how to create new leases based on the current state
 * of the lease table (i.e. whether the lease table is empty or non-empty).
 */
interface LeaseSynchronizer {

    /**
     * Determines how to create leases.
     * @param shards
     * @param currentLeases
     * @param initialPosition
     * @param inconsistentShardIds
     * @return
     */
    List<KinesisClientLease> determineNewLeasesToCreate(List<Shard> shards,
                                                        List<KinesisClientLease> currentLeases,
                                                        InitialPositionInStreamExtended initialPosition,
                                                        Set<String> inconsistentShardIds);
}