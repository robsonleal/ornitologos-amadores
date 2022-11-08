import { createTheme } from '@mui/material';
import { blue, indigo } from '@mui/material/colors';

export const DarkTheme = createTheme({
  palette: {
    primary: {
      main: indigo[700],
      dark: indigo[800],
      light: indigo[500],
      contrastText: '#FFFFFF',
    },
    secondary: {
      main: blue[700],
      dark: blue[800],
      light: blue[500],
      contrastText: '#FFFFFF',
    },
    background: {
      default: '#202124',
      paper: '#303134',
    },
  },
});
