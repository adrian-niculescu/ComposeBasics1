package com.adriann.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adriann.example.composearticle.ui.theme.ComposeArticleTheme

private val GLOBAL_PADDING = 16.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    JetpackComposeArticle(
                        title = stringResource(R.string.article_title_text),
                        articleIntro = stringResource(R.string.article_intro_text),
                        articleBody = stringResource(R.string.article_body_text)
                    )
                }
            }
        }
    }
}

@Composable
fun JetpackComposeArticle(title: String, articleIntro: String, articleBody: String) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top)
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(
                start = GLOBAL_PADDING,
                end = GLOBAL_PADDING,
                bottom = GLOBAL_PADDING,
                top = GLOBAL_PADDING,
            )
        )
        Text(
            text = articleIntro,
            modifier = Modifier.padding(
                start = GLOBAL_PADDING,
                end = GLOBAL_PADDING,
            ),
            textAlign = TextAlign.Justify
        )
        Text(
            text = articleBody,
            modifier = Modifier.padding(
                start = GLOBAL_PADDING,
                end = GLOBAL_PADDING,
                bottom = GLOBAL_PADDING,
                top = GLOBAL_PADDING,
            ),
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        JetpackComposeArticle(
            title = stringResource(R.string.article_title_text),
            articleIntro = stringResource(R.string.article_intro_text),
            articleBody = stringResource(R.string.article_body_text)
        )
    }
}