<<<<<<< HEAD
import { Container, CssBaseline, Grid } from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';

import { Banner } from './shared/components/Banner';
import { Footer } from './shared/components/Footer';
import { GridCard } from './shared/components/GridCard';
import { Topbar } from './shared/components/Topbar';

const cards = [1, 2, 3, 4, 5, 6, 7, 8, 9];

const theme = createTheme();

export default function Album() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Topbar position='relative' />
      <main>
        <Banner />

        <Container sx={{ py: 8 }} maxWidth='md'>
          <Grid container spacing={4}>
            {cards.map((card) => (
              <GridCard value={card} key={card} />
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
=======
import { Container, CssBaseline, Grid } from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';

import { Banner } from './shared/components/banner/Banner';
import { Footer } from './shared/components/Footer';
import { GridCard } from './shared/components/GridCard';
import { Topbar } from './shared/components/Topbar';

const cards = [1, 2, 3, 4, 5, 6, 7, 8, 9];

const theme = createTheme();

export default function Album() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Topbar position='relative' />
      <main>
        <Banner />

        <Container sx={{ py: 8 }} maxWidth='md'>
          <Grid container spacing={4}>
            {cards.map((card) => (
              <GridCard value={card} key={card} />
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
>>>>>>> main
