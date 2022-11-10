import { BrowserRouter } from 'react-router-dom';

import { AppRoutes } from './routes';
import { BarraTopo, MenuLateral } from './shared/components';

import {
  AppThemeProvider,
  BarraTopoProvider,
  DrawerProvider,
} from './shared/contexts';

export default function App() {
  return (
    <AppThemeProvider>
      <DrawerProvider>
        <BarraTopoProvider>
          <BrowserRouter>
            <MenuLateral>
              <BarraTopo />
              <AppRoutes />
            </MenuLateral>
          </BrowserRouter>
        </BarraTopoProvider>
      </DrawerProvider>
    </AppThemeProvider>
  );
}
