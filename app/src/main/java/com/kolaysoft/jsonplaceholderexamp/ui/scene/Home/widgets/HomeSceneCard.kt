package com.kolaysoft.jsonplaceholderexamp.ui.scene.Home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kolaysoft.jsonplaceholderexamp.data.model.UserModel

@Composable
fun HomeSceneCard(user: UserModel) {
    val modifier = Modifier
    var isExpanded by remember { mutableStateOf(false) }

    if (!isExpanded) {
        Card(
            modifier = modifier.height(70.dp), colors = CardDefaults.cardColors(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Column(modifier = modifier.padding(15.dp)) {
                    Text(text = user.name, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                    Text(text = user.phone, style = TextStyle(fontSize = 15.sp))
                }
                IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "")
                }
            }


        }
    } else {
        Card(modifier = modifier.height(150.dp), colors = CardDefaults.cardColors(Color.White)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Column(modifier = modifier.padding(15.dp)) {
                    Text(text = user.name, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                    Text(text = user.phone, style = TextStyle(fontSize = 15.sp))
                    Text(text = user.username, style = TextStyle(fontSize = 15.sp))
                    Text(text = user.email, style = TextStyle(fontSize = 15.sp))
                    Text(text = user.website, style = TextStyle(fontSize = 15.sp))
                    Text(text = user.address.city, style = TextStyle(fontSize = 15.sp))

                }
                IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "")
                }
            }
        }
    }


}

@Preview
@Composable
fun HomeSceneCardPreview() {
    HomeSceneCard(
        user = UserModel(
            id = 1,
            name = "John Doe",
            username = "johndoe",
            email = "johndoe@example.com",
            address = UserModel.Address("California", UserModel.Address.Geo("", ""), "", "", ""),
            phone = "1234567890",
            website = "johndoe.com",
            company = UserModel.Company("", "", "")
        )
    )
}