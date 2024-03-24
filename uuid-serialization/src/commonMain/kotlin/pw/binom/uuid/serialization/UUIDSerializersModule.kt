package pw.binom.uuid.serialization

import kotlinx.serialization.modules.SerializersModule
import pw.binom.uuid.UUID

object UUIDSerializersModule {
    val BINARY = SerializersModule {
        contextual(UUID::class, UUIDLongSerializer)
    }

    val TEXT = SerializersModule {
        contextual(UUID::class, UUIDStringSerializer)
    }
}
