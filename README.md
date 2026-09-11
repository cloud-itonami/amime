# amime 網目 — multi-site energy MESH flow-network

The system-of-systems **energy-flow** layer of the Energy Order suite (ADR-2606211200).
hikari designs one site; mio verifies the aggregate Flowrate; **amime models how ordered
energy flows BETWEEN sites** over a mesh of capacity-bounded, lossy links — transportation
flow, transmission loss, curtailment, **N-1 contingency** (the critical chokepoint), and
per-site import-dependence (SPOF).

A **commons mesh, never a market** (no price / no trade). A **resilience map, never a
target-list**. **Sim only** — amime never dispatches; hikari actuates under Council gate.

```bash
kbb -M:test                              # 12 tests / 55 assertions
kbb -M:mesh                              # mesh flow + N-1 report
kbb -M:emit                              # regenerate the committed kaname mirror
```

- ADR-2606212020 · clj-native R0 · `com.etzhayyim.amime.*`
- Emits `out/energy-sos.kotoba.edn` → joined by **kaname 要** as the `:energy` domain (ADR-2606212000).
- See `CLAUDE.md` for the model, invariants, and composition diagram.
