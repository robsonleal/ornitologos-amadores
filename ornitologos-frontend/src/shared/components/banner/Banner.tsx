import {
  Box,
  Button,
  Container,
  Stack,
  Typography,
  useTheme,
} from '@mui/material';
import Link from '@mui/material/Link';

import MulherImg from '../../assets/mulher_binoculos_d.png';

export function Banner() {
  const theme = useTheme();

  return (
    <Box
      sx={{
        bgcolor: theme.palette.background.paper,
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        flexDirection: 'row',
        margin: theme.spacing(6),
        borderRadius: theme.shape.borderRadius,
        boxShadow: 4,
        height: 780,
      }}
    >
      <Box
        sx={{
          bgcolor: theme.palette.background.paper,
          p: theme.spacing(8),
        }}
      >
        <Container maxWidth='sm'>
          <Typography
            style={theme.typography.h2}
            align='center'
            color={theme.palette.text.primary}
            gutterBottom
          >
            Conheça o melhor catálogo de aves
          </Typography>
          <Typography
            align='center'
            style={theme.typography.h6}
            color={theme.palette.text.secondary}
            paragraph
          >
            Registre-se para ser notificado das atualizações no catálogo e para
            ter acesso a recursos especiais da aplicação.
          </Typography>
          <Stack
            sx={{ pt: theme.spacing(4) }}
            direction='row'
            spacing={2}
            justifyContent='center'
          >
            <Button variant='contained'>Ir para o catálogo</Button>
            <Button variant='outlined'>
              <Link href="/login" style={{textDecoration: 'none'}} >
                    Entrar
              </Link>
              </Button>
          </Stack>
        </Container>
      </Box>
      <Box>
        <img src={MulherImg} alt='Mulher segurando binóculos' />
      </Box>
    </Box>
  );
}
