package com.redvelvet.trivia_game.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.trivia_game.ui.theme.ButtonColor
import com.redvelvet.trivia_game.ui.theme.Poppins
import com.redvelvet.trivia_game.ui.theme.White



@Composable
fun PlayAgainButton(onPlayAgain:() -> Unit) {
    Button(
        onClick = { onPlayAgain() },
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        enabled = true,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(ButtonColor),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Text(
            text = "Play Again",
            fontFamily = Poppins,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = White,
        )

    }
}

@Preview
@Composable
fun PreviewLoginButton() {
    PlayAgainButton({})
}


