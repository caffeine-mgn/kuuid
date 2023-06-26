package pw.binom.uuid

inline fun String.toUUID() = UUID.fromString(this)

fun String.toUUIDOrNull() = try {
    UUID.fromString(this)
} catch (e: Throwable) {
    null
}
