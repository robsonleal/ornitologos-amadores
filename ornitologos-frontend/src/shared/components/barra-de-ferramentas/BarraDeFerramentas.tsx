import { Search as SearchIcon } from '@mui/icons-material';
import {
  Box,
  Button,
  InputAdornment,
  Paper,
  TextField,
  useTheme,
} from '@mui/material';

export const BarraDeFerramentas: React.FC = () => {
  
  const theme = useTheme();

  return (
    <Box
      height={theme.spacing(7)}
      padding={1}
      display='flex'
      alignItems='center'
      gap={2}
      component={Paper}
      elevation={3}
    >
      <TextField
        size='small'
        label='Pesquisar'
        id='outlined-start-adornment'
        sx={{ flexGrow: 1 }}
        InputProps={{
          endAdornment: (
            <InputAdornment position='end'>
              <SearchIcon />
            </InputAdornment>
          ),
        }}
      />
      <Button variant='contained' color='primary' type='submit'>
        Pesquisar
      </Button>
    </Box>
  );
};
