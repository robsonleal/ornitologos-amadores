import { Button, Stack, useTheme } from '@mui/material';
import { LayoutBaseDePaginaInicial } from '../../shared/layouts';

import { useNavigate } from 'react-router-dom';
import MulherImg from '../../shared/assets/mulher_binoculos_d.png';
import { useAuthContext } from '../../shared/contexts';

export const PaginaInicial = () => {
  const theme = useTheme();
  const navigate = useNavigate();
  const { isAuthenticated } = useAuthContext();
  const titulo = 'Conheça o melhor catálogo de aves';
  const subtitulo =
    'Registre-se para ser notificado das atualizações no catálogo\
     e para ter acesso a recursos especiais da aplicação.';
  const image = {
    src: MulherImg,
    alt: 'Mulher segurando binóculos',
  };
  const handleClickNavigate = (to: string) => {
    navigate(to);
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
        <Button
          color='secondary'
          variant='contained'
          onClick={() => handleClickNavigate('/aves')}
        >
          Ir para o catálogo
        </Button>
        {!isAuthenticated && (
          <Button
            variant='outlined'
            onClick={() => handleClickNavigate('/cadastro')}
          >
            Registrar
          </Button>
        )}
      </Stack>
    </LayoutBaseDePaginaInicial>
  );
};
