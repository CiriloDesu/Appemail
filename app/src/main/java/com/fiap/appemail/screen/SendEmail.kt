package com.fiap.appemail.screen

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.appemail.ui.theme.Shapes
import com.fiap.appemail.ui.theme.SkyBlue
import com.fiap.appemail.ui.theme.Teal200

@Composable
fun SendEmailScreen() {
    val context = LocalContext.current
    var to by remember { mutableStateOf(TextFieldValue("")) }
    var cc by remember { mutableStateOf(TextFieldValue("")) }
    var bcc by remember { mutableStateOf(TextFieldValue("")) }
    var subject by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Send an Email", fontSize = 30.sp, modifier = Modifier.padding(bottom = 20.dp))
            OutlinedTextField(
                value = to,
                onValueChange = { to = it },
                label = { Text("To") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Teal200,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = cc,
                onValueChange = { cc = it },
                label = { Text("Cc") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Teal200,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = bcc,
                onValueChange = { bcc = it },
                label = { Text("Bcc") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Teal200,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = subject,
                onValueChange = { subject = it },
                label = { Text("Subject") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Teal200,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Message") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Teal200,
                    unfocusedBorderColor = Color.Black
                ),
                maxLines = 8
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    sendEmail(context, to.text, cc.text, bcc.text, subject.text, message.text)
                },
                shape = Shapes.small, // Use Shapes.small para o shape do botão
                colors = ButtonDefaults.buttonColors(Teal200) // Use a cor definida (Teal200)
            ) {
                Text("Send Email")
            }

        }
}}



fun sendEmail(context: Context, to: String, cc: String, bcc: String, subject: String, message: String) {
    val emailIntent = Intent(Intent.ACTION_SEND).apply {
        type = "message/rfc822"
        putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        putExtra(Intent.EXTRA_CC, arrayOf(cc))
        putExtra(Intent.EXTRA_BCC, arrayOf(bcc))
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, message)
    }

    try {
        context.startActivity(Intent.createChooser(emailIntent, "Select Email Client"))
    } catch (e: android.content.ActivityNotFoundException) {
        Toast.makeText(context, "No email clients installed.", Toast.LENGTH_SHORT).show()
    }
}

@Preview
@Composable
fun SendEmailScreenPreview() {
    SendEmailScreen()
}

