import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nikhil.sandwichclubproject.data.model.Sandwich
import com.nikhil.sandwichclubproject.ui.viewmodel.SandwichViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: SandwichViewModel, onSandwichClick: (Sandwich) -> Unit) {
    val sandwiches by viewModel.sandwichList.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("🥪 Sandwich Club") }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 12.dp),
            modifier = Modifier.padding(padding)
        ) {
            items(sandwiches.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { onSandwichClick(sandwiches[index]) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(sandwiches[index].name),
                            contentDescription = sandwiches[index].name.mainName,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(MaterialTheme.shapes.medium)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = sandwiches[index].name.mainName,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}