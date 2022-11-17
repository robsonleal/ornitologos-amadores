import {
  Avatar,
  Box,
  Divider,
  Drawer,
  Icon,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  useTheme,
} from '@mui/material';

import { useMatch, useNavigate, useResolvedPath } from 'react-router-dom';
import { useAuthContext, useDrawerContext } from '../../contexts';

interface IListItemLinkProps {
  to: string;
  icon: string;
  label: string;
  onClick: (() => void) | undefined;
}

const ListItemLink: React.FC<IListItemLinkProps> = ({
  to,
  icon,
  label,
  onClick,
}) => {
  const navigate = useNavigate();

  const resolvedPath = useResolvedPath(to);
  const match = useMatch({ path: resolvedPath.pathname, end: true });

  const handleClick = () => {
    onClick?.();
    navigate(to);
  };

  return (
    <ListItem>
      <ListItemButton selected={!!match} onClick={handleClick}>
        <ListItemIcon>
          <Icon>{icon}</Icon>
        </ListItemIcon>
        <ListItemText primary={label} />
      </ListItemButton>
    </ListItem>
  );
};

interface IMenuLateralProps {
  children: React.ReactNode;
}

export const MenuLateral: React.FC<IMenuLateralProps> = ({ children }) => {
  const theme = useTheme();

  const { isDrawerOpen, toggleDrawerOpen, drawerOptions } = useDrawerContext();
  const { logout } = useAuthContext();

  return (
    <>
      <Drawer
        anchor='right'
        open={isDrawerOpen}
        variant='temporary'
        onClose={toggleDrawerOpen}
      >
        <Box
          width={theme.spacing(35)}
          height='100%'
          display='flex'
          flexDirection='column'
        >
          <Box
            width='100%'
            height={theme.spacing(20)}
            display='flex'
            alignItems='center'
            justifyContent='center'
          >
            <Avatar
              sx={{ height: theme.spacing(12), width: theme.spacing(12) }}
              src='https://github.com/robsonleal.png'
            />
          </Box>

          <Divider />

          <Box flex={1}>
            <List>
              {drawerOptions.map((drawerOption) => (
                <ListItemLink
                  key={drawerOption.path}
                  icon={drawerOption.icon}
                  to={drawerOption.path}
                  label={drawerOption.label}
                  onClick={toggleDrawerOpen}
                />
              ))}
              <ListItemLink
                icon='logout'
                to='/'
                label='Sair'
                onClick={() => {
                  logout(), toggleDrawerOpen();
                }}
              />
            </List>
          </Box>
        </Box>
      </Drawer>

      <Box height='100vh'>{children}</Box>
    </>
  );
};
