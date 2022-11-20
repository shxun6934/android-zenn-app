package com.example.zenn_app.core.network.model.util

import kotlinx.datetime.Instant
import kotlinx.datetime.toInstant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object InstantSerializer : KSerializer<Instant> {

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(
            serialName = "Instant",
            kind = PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): Instant =
        decoder.decodeString().toInstant()

    override fun serialize(encoder: Encoder, value: Instant) =
        encoder.encodeString(value.toString())
}
