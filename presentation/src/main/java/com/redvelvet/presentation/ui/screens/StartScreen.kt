package com.redvelvet.presentation.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.composable.IconButtons
import com.redvelvet.presentation.ui.theme.PrimaryColor
import com.redvelvet.presentation.ui.theme.White

@Composable
fun StartScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ) {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround) {
            Box() {

                Image(
                    painter = painterResource(id = R.drawable.trv_logo),
                    contentDescription = "logo trivia stars",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(230.dp)
                        .padding(top = 24.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.frame_upper_stars),
                    contentDescription = "stars",
                    modifier = Modifier
                        .requiredSize(LocalConfiguration.current.screenWidthDp.dp, 270.dp),
                    contentScale = ContentScale.FillBounds
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    IconButtons(
                        onClick = {},
                        icon = painterResource(id = R.drawable.ic_start_game),
                        size = 194,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Image(
                        painter = painterResource(id = R.drawable.stars_around_icon),
                        contentDescription = "stars",
                        modifier = Modifier
                            .requiredSize(LocalConfiguration.current.screenWidthDp.dp, 270.dp),
                    )
                }
            }

            Row(
                Modifier
                    .align(Alignment.End)
                    .shadow(
                        7.dp,
                        RoundedCornerShape(bottomStart = 56.dp, topStart = 56.dp),
                        spotColor = White,
                        ambientColor = White
                    )
                    .height(64.dp)
                    .background(White, RoundedCornerShape(bottomStart = 56.dp, topStart = 56.dp)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_point),
                        tint = Color.Unspecified,
                        contentDescription = "total points",

                        )
                    Spacer(modifier = Modifier.width(24.dp))

                    Text(
                        text = "1200",
                        color = PrimaryColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Total Points",
                        color = PrimaryColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_double_arrow__up),
                    contentDescription = null, tint = White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Swipe up", color = White)
            }
        }
    }
}


@Preview(showBackground = true, locale = "En")
@Composable
fun Preview() {
    StartScreen()
}