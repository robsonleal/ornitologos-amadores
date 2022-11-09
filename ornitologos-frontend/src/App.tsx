import { BrowserRouter } from 'react-router-dom';

import { AppRoutes } from './routes';
import { BarraTopo, MenuLateral } from './shared/components';

import { AppThemeProvider, DrawerProvider } from './shared/contexts';

export default function App() {
  return (
    <AppThemeProvider>
      <DrawerProvider>
        <BrowserRouter>
          <MenuLateral>
            <BarraTopo />
            <AppRoutes />
          </MenuLateral>
        </BrowserRouter>
      </DrawerProvider>
    </AppThemeProvider>
  );
}
