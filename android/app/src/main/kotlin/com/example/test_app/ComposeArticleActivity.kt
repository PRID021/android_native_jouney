package com.example.test_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.test_app.ui.theme.LearnFunTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeArticleActivity : BaseComposeActivity() {
    @Composable
    override fun SetView() {
        JetpackComposeGuideContent()
    }


}

@Composable
fun JetpackComposeGuideContent(){
    LearnFunTheme(
        content = {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.bg_compose_background),
                    contentDescription = stringResource(
                        R.string.background_compose_background
                    )
                )
                Text(
                    text = stringResource(id = R.string.jetpack_compose_tutorial_text),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.jectpack_intro_text),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = stringResource(id = R.string.jetpack_section_guide_text),
                    fontSize = 16.sp,
                    textAlign= TextAlign.Justify,
                    modifier = Modifier.padding( 16.dp)
                )

            }
        },
        topAppBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.jetpack_compose_title))
                },
                backgroundColor = MaterialTheme.colors.primary
            )

        },
    )

}


@Preview(showBackground = true)
@Composable
fun ComposeArticleActivityPreview() {
    JetpackComposeGuideContent()
}