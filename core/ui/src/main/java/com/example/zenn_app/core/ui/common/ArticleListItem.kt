package com.example.zenn_app.core.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.zenn_app.core.designsystem.theme.Black
import com.example.zenn_app.core.designsystem.theme.Gray60
import com.example.zenn_app.core.designsystem.theme.ZennAppTheme
import com.example.zenn_app.core.domain.model.Article
import com.example.zenn_app.core.domain.model.DisplayAuthor
import com.example.zenn_app.core.domain.model.DisplayPublication
import com.example.zenn_app.core.domain.model.DummyArticle
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.minus
import kotlinx.datetime.until

@Composable
fun ArticleListItem(
    modifier: Modifier = Modifier,
    item: Article,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Emoji(
            item = item
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                color = Black
            )
            ArticleInfo(
                modifier = Modifier.padding(top = 8.dp),
                item = item
            )
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
private fun Emoji(
    modifier: Modifier = Modifier,
    item: Article
) {
    Text(
        text = item.emoji,
        style = MaterialTheme.typography.displaySmall,
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(20.dp)
    )
}

@Composable
private fun ArticleInfo(
    modifier: Modifier = Modifier,
    item: Article
) {
    val author = item.author
    val publication = item.publication

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AvatarImage(author = author, publication = publication)

        if (publication != null) {
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = author.displayName,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = "in",
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(horizontal = 4.dp),
                        color = Gray60
                    )
                    Text(
                        text = publication.displayName,
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DiffSinceNowText(item = item)

                    LikedCountText(modifier = Modifier.padding(start = 8.dp), item = item)
                }
            }
        } else {
            Text(
                text = author.displayName,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(start = 8.dp)
            )

            DiffSinceNowText(modifier = Modifier.padding(start = 8.dp), item = item)

            LikedCountText(modifier = Modifier.padding(start = 8.dp), item = item)
        }
    }
}

@Composable
private fun AvatarImage(
    modifier: Modifier = Modifier,
    author: DisplayAuthor,
    publication: DisplayPublication?
) {
    val imageModifier = modifier
        .size(26.dp)
        .clip(CircleShape)

    author.avatarSmallUrl?.let { authorAvatarUrl ->
        publication?.avatarSmallUrl?.let { publicationAvatarUrl ->
            Box(
                modifier = modifier.size(32.dp)
            ) {
                AsyncImage(
                    model = publicationAvatarUrl,
                    contentDescription = "Publication avatar image url.",
                    modifier = Modifier
                        .size(26.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                AsyncImage(
                    model = authorAvatarUrl,
                    contentDescription = "Author avatar image url.",
                    modifier = Modifier
                        .offset(x = 14.dp, y = 14.dp)
                        .size(18.dp)
                        .clip(CircleShape)
                )
            }
        } ?: run {
            AsyncImage(
                model = authorAvatarUrl,
                contentDescription = "Author avatar image url.",
                modifier = imageModifier
            )
        }
    } ?: run {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = "No avatar image.",
            modifier = imageModifier.background(color = MaterialTheme.colorScheme.surface),
            tint = Gray60
        )
    }
}

@Composable
private fun DiffSinceNowText(
    modifier: Modifier = Modifier,
    item: Article
) {
    val today = Clock.System.now()
    val diffDays = item.publishedAt.daysUntil(today, TimeZone.of("Asia/Tokyo"))
    val diffMinutes =
        item.publishedAt.until(today, DateTimeUnit.MINUTE, TimeZone.of("Asia/Tokyo"))
    val sinceTime = if (diffMinutes >= 24 * 60) {
        "${diffDays}日前"
    } else {
        "${diffMinutes}時間前"
    }
    Text(
        text = sinceTime,
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier,
        color = Gray60
    )
}

@Composable
private fun LikedCountText(
    modifier: Modifier = Modifier,
    item: Article
) {
    Row(
        modifier = modifier.height(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = "Article liked icon.",
            tint = Gray60
        )
        Text(
            text = "${item.likedCount}",
            style = MaterialTheme.typography.labelSmall,
            color = Gray60
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xe6f2ff
)
@Composable
private fun PreviewArticleListItem() {
    ZennAppTheme {
        ArticleListItem(item = DummyArticle.dummy())
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xe6f2ff
)
@Composable
private fun PreviewEmoji() {
    ZennAppTheme {
        Emoji(item = DummyArticle.dummy())
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xe6f2ff
)
@Composable
private fun PreviewArticleInfo() {
    ZennAppTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ArticleInfo(
                item = DummyArticle.dummy().copy(
                    publication = null,
                    publishedAt = Clock.System.now()
                        .minus(1, DateTimeUnit.DAY, TimeZone.of("Asia/Tokyo"))
                )
            )
            ArticleInfo(
                item = DummyArticle.dummy().copy(
                    publishedAt = Clock.System.now()
                        .minus(6, DateTimeUnit.MINUTE, TimeZone.of("Asia/Tokyo"))
                )
            )
        }
    }
}

@Preview
@Composable
private fun PreviewAvatarImage() {
    ZennAppTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AvatarImage(
                author = DisplayAuthor.dummy().copy(avatarSmallUrl = null),
                publication = null
            )
            AvatarImage(
                author = DisplayAuthor.dummy(),
                publication = null
            )
            AvatarImage(
                author = DisplayAuthor.dummy(),
                publication = DisplayPublication.dummy()
            )
        }
    }
}
