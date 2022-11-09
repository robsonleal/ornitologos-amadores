import { Button, Stack, useTheme } from '@mui/material';
import { LayoutBaseDePaginaInicial } from '../../shared/layouts';

import MulherImg from '../../shared/assets/mulher_binoculos_d.png';

export const PaginaInicial = () => {
  const theme = useTheme();
  const titulo = 'Conheça o melhor catálogo de aves';
  const subtitulo =
    'Registre-se para ser notificado das atualizações no catálogo\
     e para ter acesso a recursos especiais da aplicação.';
  const image = {
    src: MulherImg,
    alt: 'Mulher segurando binóculos',
  };

  return (
    <LayoutBaseDePaginaInicial
      titulo={titulo}
      subtitulo={subtitulo}
      image={image}
    >
      <Stack
        sx={{ pt: theme.spacing(4) }}
        direction='row'
        spacing={2}
        justifyContent='center'
      >
        <Button variant='contained' color='secondary'>
          Ir para o catálogo
        </Button>
        <Button variant='outlined'>Entrar</Button>
      </Stack>
    </LayoutBaseDePaginaInicial>
  );
};
