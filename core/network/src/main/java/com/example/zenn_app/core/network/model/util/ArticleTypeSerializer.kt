package com.example.zenn_app.core.network.model.util

import com.example.zenn_app.core.model.data.type.ArticleType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object ArticleTypeSerializer : KSerializer<ArticleType> {

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(
            serialName = "ArticleType",
            kind = PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): ArticleType =
        ArticleType.findIdentifier(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: ArticleType) =
        encoder.encodeString(value.identifier)
}
