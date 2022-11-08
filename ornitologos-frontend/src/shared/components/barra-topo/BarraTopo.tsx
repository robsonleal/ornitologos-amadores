
export {};
import {
  AppBar,
  Avatar,
  Box,
  Button,
  Container,
  IconButton,
  Toolbar,
  Tooltip,
  Typography,
} from '@mui/material';
import { useAppThemeContext, useDrawerContext } from '../../contexts';
import { MaterialUISwitch } from '../MaterialUISwitch';

export function BarraTopo() {
  const pages = ['PAGINA INICIAL', 'AVISTAMENTOS', 'CATÁLOGO'];
  const { toggleTheme } = useAppThemeContext();
  const { toggleDrawerOpen } = useDrawerContext();

  return (
    <AppBar position='static'>
      <Container maxWidth='xl'>
        <Toolbar disableGutters>
          <Typography
            variant='h6'
            noWrap
            component='a'
            href='/'
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              flexGrow: 1,
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'inherit',
              textTransform: 'uppercase',
              textDecoration: 'none',
            }}
          >
            Ornitólogos amadores
          </Typography>

          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            {pages.map((page) => (
              <Button
                key={page}
                onClick={() => console.log('oi')}
                sx={{
                  my: 2,
                  color: 'white',
                  display: 'block',
                  textTransform: 'uppercase',
                }}
              >
                {page}
              </Button>
            ))}
          </Box>

          <Box sx={{ flexGrow: 0 }}>
            <MaterialUISwitch onChange={toggleTheme} />
            <Tooltip title='Menu do usuário'>
              <IconButton onClick={toggleDrawerOpen} sx={{ p: 0 }}>
                <Avatar alt='Remy Sharp' src='/static/images/avatar/2.jpg' />
              </IconButton>
            </Tooltip>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
