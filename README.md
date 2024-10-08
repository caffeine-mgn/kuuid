# Binom UUID
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Kotlin 1.9.23](https://img.shields.io/badge/Kotlin-1.9.23-blue.svg?style=flat&logo=kotlin)](http://kotlinlang.org)

## Description
Library UUID v4 implementation

## Get starting
Add to your `build.gradle.kts` file new dependency:
```kotlin
kotlin {
    api("pw.binom:uuid:0.0.7") // uuid library
    api("pw.binom:uuid-serialization:0.0.7") // serialization uuid library for kotlinx-serialization
}
```

## Example
```kotlin
import pw.binom.uuid.UUID

Random.nextUuid() // generate random uuid
"f9d992e7-94f4-4697-88e7-099e580a6bc1".toUUID() // returns uuid or throw exception
"f9d992e7-94f4-4697-88e7-099e580a6bc1".toUUIDOrNull() // returns uuid or null in cases when string content has not valid uuid
UUID.random() // generate random uuid
UUID.create(data = byteArrayOf(/*bytes*/), offset = 0) // create from byte array
UUID.create(mostSigBits = 10L, leastSigBits = 20L) // create from two longs
UUID.fromString("f9d992e7-94f4-4697-88e7-099e580a6bc1") // create from string
UUID.random().toByteArray() // convert uuid to byte array
UUID.random().toByteArray(destination = ByteArray(UUID.SIZE_BYTES), destinationOffset = 0) // convert uuid to given byte array, not creating new
UUID.random().toString() // converting to string
UUID.random().toShortString() // getting uuid as "short uuid" (first 8 bytes of uuid)
```