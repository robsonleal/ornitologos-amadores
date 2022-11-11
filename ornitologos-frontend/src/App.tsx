import { BrowserRouter } from 'react-router-dom';

import { AppRoutes } from './routes';
import { BarraTopo, MenuLateral } from './shared/components';

import {
  AppThemeProvider,
  AuthProvider,
  BarraTopoProvider,
  DrawerProvider,
} from './shared/contexts';

export default function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <AppThemeProvider>
          <DrawerProvider>
            <BarraTopoProvider>
              <MenuLateral>
                <BarraTopo />
                <AppRoutes />
              </MenuLateral>
            </BarraTopoProvider>
          </DrawerProvider>
        </AppThemeProvider>
      </AuthProvider>
    </BrowserRouter>
  );
}
