import {
  Box,
  Button,
  Icon,
  InputAdornment,
  Paper,
  TextField,
  useTheme,
} from '@mui/material';

interface IBarraDeFerramentasProps {
  textoDaBusca?: string;
  mostrarInputBusca?: boolean;
  aoMudarTextoDeBusca?: (novoTexto: string) => void;
  textoBotaoNovo?: string;
  mostrarBotaoNovo?: boolean;
  aoClicarEmNovo?: () => void;
}

export const BarraDeFerramentas: React.FC<IBarraDeFerramentasProps> = ({
  textoDaBusca = '',
  aoMudarTextoDeBusca,
  mostrarInputBusca = true,
  aoClicarEmNovo,
  textoBotaoNovo = 'Novo',
  mostrarBotaoNovo = false,
}) => {
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
      {mostrarInputBusca && (
        <TextField
          size='small'
          label='Pesquisar'
          id='outlined-start-adornment'
          value={textoDaBusca}
          placeholder='Comece a digitar sua pesquisa ...'
          onChange={(e) => aoMudarTextoDeBusca?.(e.target.value)}
          sx={{ flexGrow: 1 }}
          InputProps={{
            endAdornment: (
              <InputAdornment position='end'>
                <Icon>search_icon</Icon>
              </InputAdornment>
            ),
          }}
        />
      )}

      {mostrarBotaoNovo && (
        <Button
          variant='contained'
          color='secondary'
          onClick={aoClicarEmNovo}
          startIcon={<Icon>add</Icon>}
        >
          {textoBotaoNovo}
        </Button>
      )}
    </Box>
  );
};
