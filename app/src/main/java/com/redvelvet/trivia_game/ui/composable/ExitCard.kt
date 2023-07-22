package com.redvelvet.trivia_game.ui.composable

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.trivia_game.R
import com.redvelvet.trivia_game.ui.theme.BackgroundLight
import com.redvelvet.trivia_game.ui.theme.Black
import com.redvelvet.trivia_game.ui.theme.DarkGray
import com.redvelvet.trivia_game.ui.theme.LightGray
import com.redvelvet.trivia_game.ui.theme.Poppins
import com.redvelvet.trivia_game.ui.theme.PrimaryColor

@Composable
fun ExitCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(BackgroundLight)
            .fillMaxHeight()
            .padding(horizontal = 32.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        SpacerVertical(16)
        Image(
            painter = painterResource(id = R.drawable.warning),
            contentDescription = "you will exit from the game",
            modifier = Modifier
                .size(64.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        SpacerVertical(16)
        Text(
            text = "Are you sure you want to finish the game?",
            fontSize = 14.sp,
            color = Black,
            modifier = Modifier
                .padding(horizontal = 20.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            fontFamily = Poppins,
        )
        SpacerVertical(8)
        Text(
            text = "Finishing this game means you’re gonna lose all of your last-collected points",
            fontSize = 12.sp,
            color = DarkGray,
            modifier = Modifier
                .padding(horizontal = 40.dp),
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
        )
        SpacerVertical(32)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CancelButton(onButtonClick = {})
            SpacerHorizontal(8)
            ExitButton(onButtonClick = {})
        }


    }
}

@Composable
fun CancelButton(onButtonClick: () -> Unit) {
    Button(
        elevation = ButtonDefaults.buttonElevation(0.dp),
        onClick = onButtonClick,
        modifier = Modifier
            .width(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = LightGray)
    ) {
        Text(
            text = "Cancel",
            color = DarkGray,
            maxLines = 1,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ExitButton(onButtonClick: () -> Unit) {
    Button(
        elevation = ButtonDefaults.buttonElevation(0.dp),
        onClick = onButtonClick,
        modifier = Modifier
            .width(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor)
    ) {
        Text(
            text = "Exit",
            maxLines = 1,
            fontSize = 12.sp
        )
    }
}


@Composable
fun SpacerVertical(space: Int) {
    Spacer(modifier = Modifier.height(space.dp))
}

@Composable
fun SpacerHorizontal(space: Int) {
    Spacer(modifier = Modifier.width(space.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewExitCard() {
    ExitCard()
}