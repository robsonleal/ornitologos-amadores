import { BrowserRouter } from 'react-router-dom';

import { AppRoutes } from './routes';
import { MenuLateral } from './shared/components/menu-lateral/MenuLateral';
import { AppThemeProvider } from './shared/contexts';

export default function App() {
  return (
    <AppThemeProvider>
      <BrowserRouter>
        <MenuLateral>
          <AppRoutes />
        </MenuLateral>
      </BrowserRouter>
    </AppThemeProvider>
  );
}
