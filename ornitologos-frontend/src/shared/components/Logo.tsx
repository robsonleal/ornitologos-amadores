import { useTheme } from '@mui/material';
import LogoImg from '../assets/icon.svg';

export function Logo() {
  const theme = useTheme();

  return (
    <img
      height={theme.spacing(5)}
      src={LogoImg}
      alt='Calopsita logo da aplicação'
    />
  );
}
