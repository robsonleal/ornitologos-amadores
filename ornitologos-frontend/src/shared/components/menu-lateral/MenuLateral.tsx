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
import { useNavigate } from 'react-router-dom';

import { useDrawerContext } from '../../contexts';

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

  const handleClick = () => {
    navigate(to);
    onClick?.();
  };

  return (
    <ListItem>
      <ListItemButton onClick={handleClick}>
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

  const { isDrawerOpen, toggleDrawerOpen } = useDrawerContext();

  return (
    <>
      <Drawer
        open={isDrawerOpen}
        variant='temporary'
        onClose={toggleDrawerOpen}
      >
        <Box
          width={theme.spacing(28)}
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
              src='../../assets/profile.svg'
            />
          </Box>

          <Divider />

          <Box flex={1}>
            <List>
              <ListItemLink
                icon='person'
                to='/pagina-inicial'
                label='Ver Perfil'
                onClick={toggleDrawerOpen}
              />
            </List>
          </Box>
        </Box>
      </Drawer>

      <Box height='100vh' marginLeft={theme.spacing(28)}>
        {children}
      </Box>
    </>
  );
};
