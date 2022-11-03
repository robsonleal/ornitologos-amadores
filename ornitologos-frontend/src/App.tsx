import { Grid, CssBaseline, Container } from "@mui/material";
import { createTheme, ThemeProvider } from "@mui/material/styles";

import { Topbar } from "./components/Topbar";
import { Banner } from "./components/Banner";
import { Footer } from "./components/Footer";
import { GridCard } from "./components/GridCard";

const cards = [1, 2, 3, 4, 5, 6, 7, 8, 9];

const theme = createTheme();

export default function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Topbar position="relative" />
      <main>
        <Banner />

        <Container sx={{ py: 8 }} maxWidth="md">
          <Grid container spacing={4}>
            {cards.map((card) => (
              <GridCard value={card} />
            ))}
          </Grid>
        </Container>
      </main>
      {/* Footer */}
      <Footer />
      {/* End footer */}
    </ThemeProvider>
  );
}
