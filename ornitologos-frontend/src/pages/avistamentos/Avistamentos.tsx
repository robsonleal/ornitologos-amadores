import {
  LinearProgress,
  Modal,
  Pagination,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableFooter,
  TableHead,
  TableRow,
} from '@mui/material';
import { useEffect, useMemo, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import { BarraDeFerramentas, ModalForm } from '../../shared/components';
import { Enviroment } from '../../shared/environment';
import { useDebounce } from '../../shared/hooks';
import { LayoutBaseDePagina } from '../../shared/layouts';
import { IListagemAvistamento } from '../../shared/models';
import { AvistamentosService } from '../../shared/services/api/avistamentos/AvistamentosService';

export const Avistamentos = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const { debounce } = useDebounce();
  const [avistamentos, setAvistamentos] = useState<IListagemAvistamento[]>([]);
  const [totalCount, setTotalCount] = useState(0);
  const [isLoading, setIsLoading] = useState(true);
  const [openModal, setOpenModal] = useState(false);

  const handleOpenModal = () => {
    setOpenModal(!openModal);
  };

  const busca = useMemo(() => {
    return searchParams.get('busca') || '';
  }, [searchParams]);

  const pagina = useMemo(() => {
    return Number(searchParams.get('pagina') || '1');
  }, [searchParams]);

  useEffect(() => {
    setIsLoading(true);
    debounce(() => {
      AvistamentosService.getAll(pagina, busca).then((result) => {
        setIsLoading(false);
        if (result instanceof Error) {
          alert(result.message);
        } else {
          console.log(result);
          setAvistamentos(result.data);
          setTotalCount(result.totalCount);
        }
      });
    });
  }, [busca, pagina]);

  return (
    <LayoutBaseDePagina
      titulo='Avistamentos'
      barraDeFerramentas={
        <BarraDeFerramentas
          textoDaBusca={busca}
          aoMudarTextoDeBusca={(texto) =>
            setSearchParams({ busca: texto, pagina: '1' }, { replace: true })
          }
          mostrarBotaoNovo={true}
          aoClicarEmNovo={handleOpenModal}
        />
      }
    >
      <Modal open={openModal} onClose={handleOpenModal}>
        <ModalForm closeModal={handleOpenModal} />
      </Modal>
      <TableContainer
        component={Paper}
        variant='outlined'
        sx={{ m: 1, width: 'auto' }}
      >
        <Table>
          <TableHead>
            <TableRow>
              <TableCell width={75}>ID</TableCell>
              <TableCell width={125}>Data</TableCell>
              <TableCell width={125}>Hora</TableCell>
              <TableCell>Local</TableCell>
              <TableCell>Ave</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {avistamentos.map((avistamento) => (
              <TableRow key={avistamento.id}>
                <TableCell>{avistamento.id}</TableCell>
                <TableCell>{avistamento.data}</TableCell>
                <TableCell>{avistamento.horario}</TableCell>
                <TableCell>{avistamento.local}</TableCell>
                <TableCell>{avistamento.ave}</TableCell>
              </TableRow>
            ))}
          </TableBody>

          {totalCount === 0 && !isLoading && (
            <caption>{Enviroment.LISTAGEM_VAZIA}</caption>
          )}

          <TableFooter>
            {isLoading && (
              <TableRow>
                <TableCell colSpan={6}>
                  <LinearProgress variant='indeterminate' />
                </TableCell>
              </TableRow>
            )}
            {totalCount > 0 && totalCount > Enviroment.LIMITE_AVISTAMENTOS && (
              <TableRow>
                <TableCell colSpan={3}>
                  <Pagination
                    page={pagina}
                    count={Math.ceil(
                      totalCount / Enviroment.LIMITE_AVISTAMENTOS
                    )}
                    onChange={(_, newPage) =>
                      setSearchParams(
                        { busca, pagina: newPage.toString() },
                        { replace: true }
                      )
                    }
                  />
                </TableCell>
              </TableRow>
            )}
          </TableFooter>
        </Table>
      </TableContainer>
    </LayoutBaseDePagina>
  );
};
