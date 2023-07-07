package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.theme.BackgroundLight
import com.redvelvet.presentation.ui.theme.Black
import com.redvelvet.presentation.ui.theme.BodyColor
import com.redvelvet.presentation.ui.theme.CardBackgroundLight
import com.redvelvet.presentation.ui.theme.ContainerLight
import com.redvelvet.presentation.ui.theme.Poppins
import com.redvelvet.presentation.ui.theme.PrimaryColor
import com.redvelvet.presentation.ui.theme.White
import com.redvelvet.presentation.ui.uiStates.ConfigurationMode
import com.redvelvet.presentation.ui.uiStates.ConfigurationUiState

@Composable
fun ItemMode(
    configurationUiState: ConfigurationUiState,
    selected: ConfigurationMode,
    modifier: Modifier = Modifier,
    onClickMode: (ConfigurationUiState) -> Unit
) {
    val isSelected = configurationUiState.mode == selected
    var borderStroke: BorderStroke? = null
    var titleColor: Color? = null
    if (isSelected) {
        borderStroke = BorderStroke(width = 2.dp, color = PrimaryColor)
        titleColor = PrimaryColor
    }
    Card(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { onClickMode(configurationUiState) },
        shape = RoundedCornerShape(16.dp),
        border = borderStroke,
        colors = CardDefaults.cardColors(containerColor = CardBackgroundLight)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            SpacerHorizontal16()
            Image(
                painter = painterResource(configurationUiState.modeImage),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            SpacerHorizontal8()
            Column(modifier = Modifier.padding(vertical = 16.dp)) {
                val mode = when (configurationUiState.mode) {
                    ConfigurationMode.CASUAL_MODE -> stringResource(R.string.casual_mode)
                    ConfigurationMode.TIMED_MODE -> stringResource(R.string.timed_mode)
                    else -> stringResource(R.string.survival_mode)
                }
                Text(
                    text = mode,
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    color = titleColor ?: Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = configurationUiState.modeDescription,
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    color = BodyColor,
                    modifier = Modifier.padding(end = 16.dp)
                )

            }
        }
    }
}

@Composable
@Preview
fun previewItemMode() {
    ItemMode(
        configurationUiState = ConfigurationUiState(
            mode = ConfigurationMode.CASUAL_MODE,
            modeDescription = "Take your time, explore diverse topics, collect more points, and enjoy a stress-free trivia experience!",
        ),
        selected = ConfigurationMode.CASUAL_MODE,
        onClickMode = {}
    )
}