package com.redvelvet.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.composable.ImageWin
import com.redvelvet.presentation.ui.composable.VerticalSpacer
import com.redvelvet.presentation.ui.theme.BackgroundLight
import com.redvelvet.presentation.ui.theme.DarkGray
import com.redvelvet.presentation.ui.theme.Poppins

@Composable
fun WinScreen() {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .background(color = BackgroundLight)
            .fillMaxSize()
            .verticalScroll(state = state),
        ) {
        Box() {
            ImageWin(
                imageUrl = R.drawable.ellipse_65,
                description = stringResource(R.string.ellipsize_of_background),
                modifier = Modifier.fillMaxWidth(),
            )
            ImageWin(
                imageUrl = R.drawable.ic_winners_rafiki,
                description = stringResource(R.string.win_icon),
                modifier = Modifier
                    .padding(top = 96.dp)
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                ImageWin(
                    imageUrl = R.drawable.ic_start,
                    description = stringResource(R.string.star_icon),
                    modifier = Modifier.padding(end = 8.dp)
                )

                Text(
                    text = stringResource(R.string._1450),
                    fontSize = 20.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        VerticalSpacer(space = 24)
        Text(
            text = stringResource(id = R.string.great_job),
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
            )
        VerticalSpacer(space = 8)
        Text(
            text = stringResource(R.string.you_scored_an_impressive_10_out_of_10),
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth()
        )
        VerticalSpacer(space = 32)
        Text(
            text = stringResource(R.string.keep_up_the_excellent_work_and_continue_to_make_progress_in_the_level_congratulations),
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            fontSize = 14.sp,
            color = DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 42.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp)
            ) {
            Text(
                text = stringResource(id = R.string.play_again),
                fontSize = 18.sp,
                fontFamily = Poppins,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
                )
        }
        VerticalSpacer(space = 48)
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
fun previewWin() {
    WinScreen()
}