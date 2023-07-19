package com.redvelvet.trivia_game.ui.screen.configuration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.trivia_game.R
import com.redvelvet.trivia_game.ui.composable.AnimatedArrowIcon
import com.redvelvet.trivia_game.ui.composable.CustomDetailsScoreButton
import com.redvelvet.trivia_game.ui.composable.PulsingIcon
import com.redvelvet.trivia_game.ui.theme.OnBackgroundLight
import com.redvelvet.trivia_game.ui.theme.Poppins
import com.redvelvet.trivia_game.ui.theme.Primary

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ConfigurationScreen() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    val gridSize = 5
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val gridCellSizeWidth = screenWidth / gridSize
    val gridCellSizeHeight = screenHeight / gridSize

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = { BottomSheetContent() },
        sheetBackgroundColor = Color.White,
        sheetShape = RoundedCornerShape(
            topStart = 32.dp,
            topEnd = 32.dp,
        ),
        sheetPeekHeight = 24.dp,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Primary),
                contentAlignment = Alignment.Center
            ) {
                repeat(gridSize * gridSize) { index ->
                    val cellX = index % gridSize
                    val cellY = index / gridSize

                    val basePositionX = (cellX * gridCellSizeWidth.value).dp
                    val basePositionY = (cellY * gridCellSizeHeight.value).dp

                    val offsetX = (0..gridCellSizeWidth.value.toInt()).random()
                    val offsetY = (0..gridCellSizeHeight.value.toInt()).random()

                    Image(
                        painter = painterResource(id = R.drawable.ic_starr),
                        contentDescription = "Stars",
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.5f)),
                        modifier = Modifier
                            .size((10..50).random().dp)
                            .align(Alignment.TopStart)
                            .offset(basePositionX + offsetX.dp, basePositionY + offsetY.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp, bottom = 32.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.trv_logo),
                            contentDescription = "Logo",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(230.dp)
                        )
                    }

                    Box(
                        modifier = Modifier.size(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        PulsingIcon()
                    }

                    CustomDetailsScoreButton()
                    AnimatedArrowIcon()

                }
            }
        }
    )
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewConfigurationScreen() {
    ConfigurationScreen()
}