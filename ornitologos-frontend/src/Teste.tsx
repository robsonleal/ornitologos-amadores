<<<<<<< HEAD
import { Button } from '@mui/material';
import { useAppThemeContext, useDrawerContext } from './shared/contexts';

export function Teste() {
  const { toggleTheme } = useAppThemeContext();
  const { toggleDrawerOpen } = useDrawerContext();

  return (
    <>
      <Button variant='contained' onClick={toggleTheme}>
        Trocar tema!
      </Button>
      <Button variant='contained' onClick={toggleDrawerOpen}>
        Abrir menu!
      </Button>
    </>
  );
}
=======
import { Button } from '@mui/material';
import { useEffect } from 'react';
import { useAppThemeContext, useDrawerContext } from './shared/contexts';

export function Teste() {
  const { toggleTheme } = useAppThemeContext();
  const { toggleDrawerOpen, setDrawerOption } = useDrawerContext();

  useEffect(() => {
    setDrawerOption([
      {
        label: 'Ver Perfil',
        icon: 'person',
        path: '/pagina-inicial',
      },
    ]);
  }, []);

  return (
    <>
      <Button variant='contained' onClick={toggleTheme}>
        Trocar tema!
      </Button>
      <Button variant='contained' onClick={toggleDrawerOpen}>
        Abrir menu!
      </Button>
    </>
  );
}
>>>>>>> main
