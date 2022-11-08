import { BrowserRouter } from 'react-router-dom';
import Album from './Album';
import SignIn from './pages/SignIn';

import { AppRoutes } from './routes';
import { MenuLateral } from './shared/components/menu-lateral/MenuLateral';

import { AppThemeProvider, DrawerProvider } from './shared/contexts';

export default function App() {
  return (
    <AppThemeProvider>
      <DrawerProvider>
        <BrowserRouter>
          <MenuLateral>
            <AppRoutes />
          </MenuLateral>
        </BrowserRouter>
      </DrawerProvider>
    </AppThemeProvider>
  );
}
