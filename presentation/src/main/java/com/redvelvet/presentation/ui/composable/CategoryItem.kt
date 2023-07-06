package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.ui.theme.Poppins


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItem(
    label: String,
    iconResource: Int,
    selected: Boolean = false,
    enabled: Boolean = true,
) {
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        border = if (selected) BorderStroke(2.dp, Color(0xFF5C3570)) else null,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F1F1),
            disabledContainerColor = Color(0xFFF1F1F1),
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(21.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(iconResource),
                contentDescription = null,
                tint = Color(0xFF7B5C8B),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label,
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                color = Color(0x99121212),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}