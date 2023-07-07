package com.redvelvet.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.composable.ItemMode
import com.redvelvet.presentation.ui.theme.BackgroundLight
import com.redvelvet.presentation.ui.theme.Poppins
import com.redvelvet.presentation.ui.uiStates.ConfigurationUiState
import com.redvelvet.presentation.ui.uiStates.ConfigurationsUiState

@Composable
fun ConfigurationsBottomSheet(
    viewModel: ConfigurationViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ConfigurationsBottomSheetContent(state = state, viewModel::onClickMode)
}

@Composable
fun ConfigurationsBottomSheetContent(
    state: ConfigurationsUiState,
    onClickMode: (ConfigurationUiState) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
        Card(
            modifier = Modifier
                .height(544.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 56.dp, topEnd = 56.dp),
            colors = CardDefaults.cardColors(containerColor = BackgroundLight)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.icon_bottom_sheet),
                    contentDescription = "",
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    stringResource(R.string.configurations_title),
                    modifier = Modifier.padding(vertical = 24.dp, horizontal = 32.dp),
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(state.modes) {
                    ItemMode(
                        configurationUiState = it,
                        selected = state.selected,
                        onClickMode = onClickMode
                    )
                }
            }
        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun PreviewConfigurationBottomSheet() {
    val viewModel: ConfigurationViewModel = hiltViewModel()
    ConfigurationsBottomSheet(viewModel = viewModel)
}