import { Navigate, Route, Routes } from "react-router-dom";

import { Teste } from "../Teste";

export const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/pagina-inicial" element={<Teste />} />
      <Route path="*" element={<Navigate to="/pagina-inicial" />} />
    </Routes>
  );
};
