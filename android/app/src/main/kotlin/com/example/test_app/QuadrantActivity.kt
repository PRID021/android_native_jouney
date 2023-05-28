package com.example.test_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_app.ui.theme.LearnFunTheme

class QuadrantActivity : BaseComposeActivity() {
    @Composable
    override fun SetView() {
        LearnFunTheme(content = {
            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color(0xFFEADDFF))
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Text composable", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Displays text and follows the recommended Material Design guidelines.",
                            textAlign = TextAlign.Justify
                        )
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(48.dp) // Adjust the size
                                .padding(8.dp) // Add padding if needed
                        )
                    }
                    Column(
                        modifier = Modifier
                            .background(Color(0xFFD0BCFF))
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Image composable", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Creates a composable that lays out and draws a given Painter class object.",
                            textAlign = TextAlign.Justify
                        )
                    }


                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color(0xFFB69DF8))
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Row composable", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "A layout composable that places its children in a horizontal sequence.",
                            textAlign = TextAlign.Justify
                        )
                    }
                    Column(
                        modifier = Modifier
                            .background(Color(0xFFF6EDFF))
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Column composable", fontWeight = FontWeight.Bold,)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "A layout composable that places its children in a vertical sequence.",
                            textAlign = TextAlign.Justify
                        )
                    }

                }
            }

        })

    }

}

@Preview(showBackground = true)
@Composable
fun QuadrantActivityPreview() {
    LearnFunTheme(content = {
        Column {
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                CardQuadrant(
                    title = stringResource(R.string.text_composable),
                    description = stringResource(R.string.text_compose_guide),
                    modifier = Modifier
                        .background(Color(0xFFEADDFF))
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(16.dp),
                )
                CardQuadrant(
                    title = stringResource(R.string.image_composable),
                    description = stringResource(R.string.image_compose_guide),
                    modifier = Modifier
                        .background(Color(0xFFD0BCFF))
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(16.dp),
                )

            }
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                CardQuadrant(
                    title = stringResource(R.string.row_composable),
                    description = stringResource(R.string.row_compose_guide),
                    modifier = Modifier
                        .background(Color(0xFFB69DF8))
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(16.dp),
                )
                CardQuadrant(
                    title = stringResource(R.string.column_composable),
                    description = stringResource(R.string.column_compose_guide),
                    modifier = Modifier
                        .background(Color(0xFFF6EDFF))
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(16.dp),
                )
            }
        }

    })
}


@Composable
fun CardQuadrant(title:String,description:String,modifier: Modifier){
    Column(
        modifier =modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }

}