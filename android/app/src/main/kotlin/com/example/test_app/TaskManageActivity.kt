package com.example.test_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_app.ui.theme.LearnFunTheme

class TaskManageActivity : BaseComposeActivity() {
    @Composable
    override fun SetView() {
        LearnFunTheme(
            content = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_task_completed),
                        contentDescription = stringResource(
                            R.string.done_task_image_illustrate
                        )
                    )
                    Text(
                        text = stringResource(R.string.all_tasks_completed),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),

                        )
                    Text(
                        text = stringResource(R.string.nice_work),
                        fontSize = 16.sp
                    )
                }

            },
            topAppBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(R.string.task_completed_title))
                    },
                    backgroundColor = MaterialTheme.colors.primary
                )
            }
        )

    }


}


@Preview(showBackground = true)
@Composable
fun TaskManageActivityPreview() {
    LearnFunTheme(
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_task_completed),
                    contentDescription = stringResource(
                        R.string.done_task_image_illustrate
                    )
                )
                Text(
                    text = stringResource(R.string.all_tasks_completed),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),

                    )
                Text(
                    text = stringResource(R.string.nice_work),
                    fontSize = 16.sp
                )
            }

        },
        topAppBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.task_completed_title))
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        }
    )
}