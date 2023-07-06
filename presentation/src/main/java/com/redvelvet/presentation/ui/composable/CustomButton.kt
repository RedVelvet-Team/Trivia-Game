package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.ui.theme.Poppins


@Composable
fun CustomButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF7B5C8B),
            disabledContainerColor = Color(0xFFBFBFBF),
        ),
        enabled = enabled,
    ) {
        Text(
            text = label,
            fontFamily = Poppins,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 12.dp),
            color = Color(0xFFFFFFFF)
        )
    }
}