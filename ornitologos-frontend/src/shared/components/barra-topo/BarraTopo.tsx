import {
  AppBar,
  Avatar,
  Box,
  Button,
  Container,
  IconButton,
  List,
  ListItem,
  ListItemButton,
  ListItemText,
  Toolbar,
  Tooltip,
  Typography,
  useTheme,
} from '@mui/material';

import { useMatch, useNavigate, useResolvedPath } from 'react-router-dom';
import {
  useAppThemeContext,
  useAuthContext,
  useBarraTopoContext,
  useDrawerContext,
} from '../../contexts';

import { Logo } from '../Logo';
import { MaterialUISwitch } from './MaterialUISwitch';

interface IItemMenuProps {
  to: string;
  label: string;
}

const ListItemMenu: React.FC<IItemMenuProps> = ({ to, label }) => {
  const navigate = useNavigate();

  const resolvedPath = useResolvedPath(to);
  const match = useMatch({ path: resolvedPath.pathname, end: false });

  const handleClick = () => {
    navigate(to);
  };

  return (
    <ListItem>
      <ListItemButton selected={!!match} onClick={handleClick}>
        <ListItemText
          primary={label}
          sx={{
            textTransform: 'uppercase',
            whiteSpace: 'nowrap',
          }}
        />
      </ListItemButton>
    </ListItem>
  );
};

export function BarraTopo() {
  const theme = useTheme();
  const navigate = useNavigate();
  const { toggleTheme } = useAppThemeContext();
  const { toggleDrawerOpen } = useDrawerContext();
  const { isAuthenticated } = useAuthContext();
  const { barraTopoOptions } = useBarraTopoContext();

  const hadleClick = (to: string) => {
    navigate(to);
  };

  return (
    <AppBar position='static'>
      <Container maxWidth='xl'>
        <Toolbar
          component={Box}
          display='flex'
          justifyContent='space-between'
          disableGutters
        >
          <Box display='flex' gap={2} alignItems='center'>
            <Logo />
            <Typography
              variant='h4'
              noWrap
              style={theme.typography.h5}
              sx={{
                textTransform: 'uppercase',
              }}
            >
              Ornitólogos amadores
            </Typography>
          </Box>

          <Box>
            <List
              sx={{ display: 'flex', flexDirection: 'row', flexWrap: 'nowrap' }}
            >
              {barraTopoOptions.map((option) => (
                <ListItemMenu
                  key={option.path}
                  to={option.path}
                  label={option.label}
                />
              ))}
            </List>
          </Box>

          <Box display='flex' alignItems='center' gap={5}>
            <MaterialUISwitch onChange={toggleTheme} />
            {isAuthenticated ? (
              <Tooltip title='Menu do usuário'>
                <IconButton onClick={toggleDrawerOpen}>
                  <Avatar alt='Remy Sharp' />
                </IconButton>
              </Tooltip>
            ) : (
              <Button
                variant='contained'
                color='secondary'
                onClick={() => hadleClick('/login')}
              >
                Entrar
              </Button>
            )}
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
