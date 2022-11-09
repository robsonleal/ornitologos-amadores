import CameraIcon from '@mui/icons-material/PhotoCamera';
import { AppBar, Toolbar, Typography } from '@mui/material';

let positions:
  | 'fixed'
  | 'absolute'
  | 'sticky'
  | 'static'
  | 'relative'
  | undefined;

interface TopbarProps {
  position?: typeof positions;
}

export function Topbar({ position }: TopbarProps) {
  return (
    <AppBar position={position}>
      <Toolbar>
        <CameraIcon sx={{ mr: 2 }} />
        <Typography
          textTransform='uppercase'
          variant='h6'
          color='inherit'
          noWrap
        >
          Ornitólogos amadores
        </Typography>
      </Toolbar>
    </AppBar>
  );
}
