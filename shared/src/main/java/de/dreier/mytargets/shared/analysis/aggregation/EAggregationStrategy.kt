/*
 * Copyright (C) 2017 Florian Dreier
 *
 * This file is part of MyTargets.
 *
 * MyTargets is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2
 * as published by the Free Software Foundation.
 *
 * MyTargets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package de.dreier.mytargets.shared.analysis.aggregation

import de.dreier.mytargets.shared.analysis.aggregation.average.AverageStrategy
import de.dreier.mytargets.shared.analysis.aggregation.cluster.ClusterStrategy

enum class EAggregationStrategy {
    NONE,
    AVERAGE,
    CLUSTER;

    fun create(): IAggregationStrategy {
        return when(this) {
            NONE -> NoneStrategy()
            AVERAGE -> AverageStrategy()
            CLUSTER -> ClusterStrategy()
        }
    }
}
