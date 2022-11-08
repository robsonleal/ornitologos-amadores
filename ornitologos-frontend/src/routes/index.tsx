import { Navigate, Route, Routes } from 'react-router-dom';
import SignIn from '../pages/SignIn';
import SignUp from '../pages/SignUp';

import { Teste } from '../Teste';

export const AppRoutes = () => {
  return (
    <Routes>
      <Route path='/pagina-inicial' element={<Teste />} />
      <Route path='*' element={<Navigate to='/pagina-inicial' />} />
      <Route path='/login' element={<SignIn />} />
      <Route path='/cadastro' element={<SignUp />} />
    </Routes>
  );
};
