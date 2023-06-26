package pw.binom.uuid

import kotlin.random.Random

inline fun Random.nextUuid() = UUID.random()
