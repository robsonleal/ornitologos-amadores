import { Button } from '@mui/material';
import { useAppThemeContext } from './shared/contexts';

export function Teste() {
  const { toggleTheme } = useAppThemeContext();

  return (
    <>
      <Button variant='contained' onClick={toggleTheme}>
        Hello world!
      </Button>
    </>
  );
}
