import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
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
import com.fiap.appemail.ui.theme.Teal200
import java.util.*



@Composable
fun ReminderFormScreen() {
    val context = LocalContext.current
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var date by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Reminder",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Reminder Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Teal200,
                unfocusedBorderColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = TextFieldValue(date),
            onValueChange = {},
            label = { Text("Date") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Teal200,
                unfocusedBorderColor = Color.Black
            ),
            readOnly = true,
            enabled = false
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            openDatePicker(context) { selectedDate ->
                date = selectedDate
            }
        },
            shape = Shapes.small, // Use Shapes.small para o shape do botão
            colors = ButtonDefaults.buttonColors(Teal200)
        ) {
            Text("Select Date")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            submitReminder(context, name.text, date)
        },
            shape = Shapes.small, // Use Shapes.small para o shape do botão
            colors = ButtonDefaults.buttonColors(Teal200)
        ) {
            Text("Submit Reminder")
        }
    }
}

private fun openDatePicker(context: Context, onDateSelected: (String) -> Unit) {
    val c = Calendar.getInstance()
    val pYear = c.get(Calendar.YEAR)
    val pMonth = c.get(Calendar.MONTH)
    val pDate = c.get(Calendar.DATE)
    DatePickerDialog(context, { _, year, month, dayOfMonth ->
        onDateSelected("$dayOfMonth/${month + 1}/$year")
    }, pYear, pMonth, pDate).show()
}

private fun submitReminder(context: Context, name: String, date: String) {
    val intent = Intent(Intent.ACTION_INSERT).apply {
        type = "vnd.android.cursor.item/event"
        putExtra(CalendarContract.Events.TITLE, name)
        // Aqui você deve converter a string de data para o formato correto de tempo em milissegundos
        // para passar para o CalendarContract.EXTRA_EVENT_BEGIN_TIME
        // Este é um exemplo básico:
        putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, Calendar.getInstance().timeInMillis)
        putExtra(CalendarContract.EXTRA_EVENT_END_TIME, Calendar.getInstance().timeInMillis + 60 * 60 * 1000) // 1 hora de evento
    }
    context.startActivity(intent)
}

@Preview
@Composable
fun ReminderFormScreenPreview() {
    ReminderFormScreen()
}