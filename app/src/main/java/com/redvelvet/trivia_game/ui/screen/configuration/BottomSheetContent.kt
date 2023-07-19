package com.redvelvet.trivia_game.ui.screen.configuration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.trivia_game.R
import com.redvelvet.trivia_game.ui.composable.VerticalSpacer
import com.redvelvet.trivia_game.ui.theme.Poppins

@Composable
fun BottomSheetContent() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    var selectedGameMode by remember { mutableStateOf<GameMode?>(null) }
    val gameModes = listOf(
        GameMode(
            title = "Casual Mode",
            description = "Take your time, explore diverse topics, collect more points, and enjoy a stress-free trivia experience!",
            icon = R.drawable.causal_mode
        ),
        GameMode(
            title = "Timed Mode",
            description = "Test your speed, gather knowledge, and collect points before the timer runs out. if time expires, you lose!",
            icon = R.drawable.timed_mode
        ),
        GameMode(
            title = "Survival Mode",
            description = "Answer correctly to stay in game, any wrong answer means you’re out. See how long you can survive!",
            icon = R.drawable.survival_mode
        )
    )
    Surface(
        color = Color.White,
        modifier = Modifier.heightIn(max = screenHeight * 0.75f)
    ) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Divider(
            modifier = Modifier.width(50.dp),
            color = Color.Gray,
            thickness = 4.dp)
        VerticalSpacer(space = 32)
        Text(
            text = "Select your preferred playing mode and start your trivia adventure now!",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        gameModes.forEach { gameMode ->
            GameModeCard(
                gameMode = gameMode,
                selected = gameMode == selectedGameMode,
                onClick = { selectedGameMode = gameMode }
            )
        }
    }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBottomSheetContent() {
    BottomSheetContent()
}